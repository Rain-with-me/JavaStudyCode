@echo off
setlocal

rem ��ȡ�ű�����Ŀ¼
set SCRIPT_DIR=%~dp0
cd /d "%SCRIPT_DIR%"
if %errorlevel% neq 0 (
    echo Ŀ¼�л�ʧ�ܣ�����·���Ƿ���ȷ��
    goto end
)

rem ����HTTPS����
git config --global https.proxy https://127.0.0.1:7890
if %errorlevel% neq 0 (
    echo ����HTTPS����ʧ�ܡ�
    goto end
)

rem ��������޸�
git add .
if %errorlevel% neq 0 (
    echo ����޸�ʧ�ܣ�����Git״̬��
    goto unset_proxy
)

rem �ύ�޸�
git commit -m "�Զ��ύ����"
if %errorlevel% neq 0 (
    echo �ύ�޸�ʧ�ܣ�����Git״̬��
    goto unset_proxy
)

rem ���͵�Զ�ֿ̲�
git push origin master
if %errorlevel% neq 0 (
    echo ���͵�Զ�ֿ̲�ʧ�ܣ�����Git״̬��
    goto unset_proxy
)

echo �������ͳɹ���

:unset_proxy
rem ȡ��HTTPS��������
git config --global --unset https.proxy
if %errorlevel% neq 0 (
    echo ȡ��HTTPS��������ʧ�ܡ�
    goto end
)

:end
pause
endlocal
