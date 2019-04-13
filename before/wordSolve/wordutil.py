# encoding = utf-8
import jieba
import jieba.posseg as jbp
from collections import Counter
import nltk
import string
import re
from nltk.corpus import stopwords
from nltk.probability import FreqDist
import collections
from nltk.stem import WordNetLemmatizer
from nltk import word_tokenize, pos_tag
from nltk.corpus import wordnet


# 频率统计
# @author LELE,LU
def word_count(datalist):
    c = Counter()
    word_list = []
    for x in datalist:
        if len(x["word"]) > 1:
            c[x["word"]] += 1
            for (k, v) in c.most_common():
                key = jbp.cut(k)
                for x in key:
                    word_str = ""
                    var = str(v)
                    # print(type(var))
                    word_dict = dict(word=k, count=v, word_type=x.flag)
                    word_str = word_dict["word"] + "+" + word_dict["word_type"] + "+" + var
                    word_list.append(word_str)
    return word_list


# 中文分词
def chinese_cut(file_name):
    chg_4 = []
    chg_6 = []
    for c in open("chg4.txt", encoding="gbk"):
        if c != ' ':
            chg_4.append(c.strip("\n"))
    for c in open("chg6.txt", encoding="gbk"):
        if c != ' ':
            chg_6.append(c.strip("\n"))
    keyword_list = []
    # 停用词列表
    stop_word_list = []
    # 加载停用词
    for word in open("stop_words.txt"):
        stop_word_list.append(word.strip("\n"))
    with open(file_name, encoding="utf-8") as f:
        data = f.read()
    for x in jbp.cut(data):
        if x.flag != 'x' and x.flag != 'm' and x.word not in stop_word_list:
            # print(x.word, x.flag)
            word_dict = dict(word=x.word, word_type=x.flag, count=1)
            if x.word in chg_4:
                word_dict["level"] = "四级"
            elif x.word in chg_6:
                word_dict["level"] = "六级"
            else:
                word_dict["level"] = "其他"
            keyword_list.append(word_dict)
    return keyword_list


# 获取词性
def get_wordnet_pos(tag):
    if tag.startswith('J'):
        return wordnet.ADJ
    elif tag.startswith('V'):
        return wordnet.VERB
    elif tag.startswith('N'):
        return wordnet.NOUN
    elif tag.startswith('R'):
        return wordnet.ADV
    else:
        return None


# 英文分词
def english_cut(file_name):
    word_list = []
    final_word = []
    words_list = []
    # 四级英语词表
    wnl = WordNetLemmatizer()
    eng_4 = []
    eng_6 = []
    for e in open("eng4.txt", encoding='ISO8859-1'):
        if e != " ":
            eng_4.append(e.strip("\n"))
    for e in open("eng6.txt", encoding='ISO8859-1'):
        if e != " ":
            eng_6.append(e.strip("\n"))
    # print(eng_4)
    with open(file_name, "r") as f:
        data = f.read()
        rule = re.compile("[0-9.?!,]")
        data = rule.sub('', data)
        # 进入队列
        old_words = nltk.word_tokenize(data)
        for w in old_words:
            word_list.append(w)
        # 去除停用字和缩写
        filter_words = [word for word in word_list if
                        word not in stopwords.words('english') and word != "'s" and word != "'"]
        # print(filter_words)
        final_word = nltk.pos_tag(filter_words)
        for x in set(final_word):
            c = final_word.count(x)
            # 单词还原
            word_post = get_wordnet_pos(x[1]) or wordnet.NOUN
            original_word = wnl.lemmatize(x[0], pos=word_post)
            # print(original_word)
            word_dict = dict(word=original_word, word_type=x[1], count=c)
            if x[0] in eng_4:
                word_dict["level"] = "四级"
            elif x[0] in eng_6:
                word_dict["level"] = "六级"
            else:
                word_dict["level"] = "其他"
            words_list.append(word_dict)
        # print(words_list)
        return words_list


def write_txt(file_name,data):
    with open(file_name,'w') as f:
        f.writelines(data)


if __name__ == "__main__":
    all_words = chinese_cut("dirty_data.txt")+english_cut("dirty_data_eng.txt")
    # all_words = english_cut("dirty_data_eng.txt")
    # print(english_cut("dirty_data_eng.txt"))
    dataset = []
    for words in all_words:
        data = words["word"]+"+"+words["word_type"]+"+"+str(words["count"])+"+"+words["level"]+"\n"
        dataset.append(data)
    write_txt("dataset.txt",dataset)
    print(all_words)
