@echo off

cd E:\STUDY\gulimall\nacos\bin\
start shutdown.cmd
choice /t 5 /d y /n >nul
start startup.cmd
echo "启动nacos服务"
