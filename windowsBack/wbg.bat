@echo off 
set regadd=reg add "HKCU\Software\Microsoft\Windows\CurrentVersion\Policies\System"
%regadd%" /v TileWallpaper /d "0" /f 
%regadd%" /v Wallpaper /d "D:\226\images\test\bg.jpg" /f
%regadd%" /v WallpaperStyle /d "2" /f 
RunDll32.exe USER32.DLL,UpdatePerUserSystemParameters 
exit