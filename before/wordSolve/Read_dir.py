import os

#@author LELE,LU
# 读取文件夹内所有文件
# return: 目录下所有的文件
def get_all_files(path):
    file_list = []
    files = os.listdir(path)
    for file in files:
        file_list.append(file)
    return file_list


# 读取srt的文件
# 返回未分词的脏数据
# @param count --> 统计字幕文件的行数
# @param old_data --> 文件中读取的字幕
def read_srt(file_name):
    count = 0
    old_data = []
    # 读取文件，指定编码格式
    with open(file_name, 'r', encoding='gbk') as f:
        data = f.readlines()
        for line in data:
            old_data.append(line)
            count = count + 1
    # 前后一条字幕相隔6行
    i = 6
    new_data = ''
    while i <= count:
        line = old_data[i]
        new_data += line.strip("\n")
        i += 8
    return new_data
    # print(new_data)


# 写入文本文件
def write_text(data, file_name):
    with open(file_name, 'a', encoding='utf-8') as f:
        f.write(data)


# 读取指定文件夹内的srt字幕文件
def dir_read(path):
    file_list = get_all_files(path)
    for file in file_list:
        # 读取指定.srt的文件
        if file[-8:] == ".chs.srt":
            print(file)
            data = read_srt(file)
            write_text(data, "dirty_data.txt")
        elif file[-8:] == ".eng.srt":
            print(file)
            data = read_srt(file)
            write_text(data, "dirty_data_eng.txt")


if __name__ == '__main__':
    dir_read("/Users/leerlu/PycharmProjects/split_words/wordSolve")
