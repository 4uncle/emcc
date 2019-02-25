from snownlp import SnowNLP
import pprint
class Read(object):
	"""docstring for Read"""
	def __init__(self, arg):
		super(Read, self).__init__()
		self.arg = arg
	@staticmethod	
	def file_read_two(file_name,file_name_two,video_name,video_type):
		datasetList = []
		keywordsList = []
		with open(file_name,encoding ='gbk') as file_obj,open(file_name_two,encoding = 'gbk') as file_obj2:
			while True :
				 content2 = file_obj2.readline()
				 content = file_obj.readline()
				 if not content :
				 	break
				 content2 = file_obj2.readline()
				 content = file_obj.readline()
				 time = content
				 split = time.split(' --> ')
				 start_time = split[0]
				 end_time =split[1].strip('\n')
				 #print(start_time)
				 #print(end_time)
				 content2 = file_obj2.readline()
				 content = file_obj.readline()
				 chinese = content.strip('\n')
				 english = content2.strip('\n')
				 feeling = SnowNLP(english)
				 #print(chinese)
				 content = file_obj.readline()
				 content2 = file_obj2.readline()
				 print(video_name,'+',start_time,'+',end_time,'+',english,'+',chinese,'+',video_type,'+',feeling.sentiments*100)
				 d = dict(startTime = start_time,endTime = end_time,chinese_subtitle = chinese,english_subtitle = english,emotion = feeling.sentiments*100,videoName = video_name,videoType = video_type)
				 datasetList.append(d)
		return datasetList

#参数分别为英文字幕路径，中文字幕路径，影片明以及影片类型
Read.file_read_two('F:\\data\\db1\\[Karen.Thompson.Walker.我们能从恐惧中学到什么].KarenThompsonWalker_2012G-480p.chs.srt','F:\\data\\db1\\[Karen.Thompson.Walker.我们能从恐惧中学到什么].KarenThompsonWalker_2012G-480p.eng.srt','我们能从恐惧中学到什么','演讲')
input('enter a key out of the test')
