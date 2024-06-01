@echo off
setlocal

rem 获取脚本所在目录
set SCRIPT_DIR=%~dp0
cd /d "%SCRIPT_DIR%"
if %errorlevel% neq 0 (
    echo 目录切换失败，请检查路径是否正确。
    goto end
)

rem 设置HTTPS代理
git config --global https.proxy https://127.0.0.1:7890
if %errorlevel% neq 0 (
    echo 设置HTTPS代理失败。
    goto end
)

rem 添加所有修改
git add .
if %errorlevel% neq 0 (
    echo 添加修改失败，请检查Git状态。
    goto unset_proxy
)

rem 提交修改
git commit -m "自动提交代码"
if %errorlevel% neq 0 (
    echo 提交修改失败，请检查Git状态。
    goto unset_proxy
)

rem 推送到远程仓库
git push origin master
if %errorlevel% neq 0 (
    echo 推送到远程仓库失败，请检查Git状态。
    goto unset_proxy
)

echo 代码推送成功。

:unset_proxy
rem 取消HTTPS代理设置
git config --global --unset https.proxy
if %errorlevel% neq 0 (
    echo 取消HTTPS代理设置失败。
    goto end
)

:end
pause
endlocal
