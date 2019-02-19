<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="${pageContext.request.contextPath }/static/js/video.js"></script>
	<script src="${pageContext.request.contextPath }/static/js/video.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/js/jquery.dataTables.min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery.js"></script>

	<title>视频播放</title>

</head>
<body>
	<div align="center" >
	<video controls style="width: 814px;">
			<source  src="${pageContext.request.contextPath}/static/video/${timeMap.videoName}#t=${timeMap.startTime},${timeMap.endTime}"  type="video/mp4">
			<div>
				<button onclick="document.getElementById('demo').play()">播放声音</button>
				  <button onclick="document.getElementById('demo').pause()">暂停声音</button>
				  <button onclick="document.getElementById('demo').volume+=0.1">提高音量</button>
				  <button onclick="document.getElementById('demo').volume-=0.1">降低音量</button>
			</div>
		<track kind="subtitles" src="/static/video/${timeMap.chineseSub}" name="caption" srclang="zh" label="Chinese" default>
		<track kind="subtitles" src="/static/video/${timeMap.englishSub}" name="caption" srclang="en" label="English">
	</video>
		<div>
			<button onClick="document.location.reload()" class="button border-black button-big button-block" style="width: 814px;">重播</button></a>
		</div>
	</div>
</body>
</html>