@echo off

cd E:\STUDY\gulimall\nacos\bin\
start shutdown.cmd

choice /t 5 /d y /n >nul
start startup.cmd
echo "启动nacos服务"

choice /t 5 /d y /n >nul
cd E:\Elasticsearch\elasticsearch-7.13.4\bin\
start elasticsearch.bat
echo "启动es服务"

choice /t 5 /d y /n >nul
cd E:\Elasticsearch\kibana-7.13.4-windows-x86_64\bin\
start kibana.bat
echo "启动kibana服务"


