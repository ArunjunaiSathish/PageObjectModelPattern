java -jar selenium-server-standalone-2.48.2.jar -role wd -port 5557 -hub http://localhost:4444/grid/register -browser browserName=firefox,maxInstances=3

-browser "browserName=chrome,version=13.0,platform=windows" -Dwebdriver.chrome.driver=C:\drivers\chrome\chromedriver.exe
If you access to

http://hubUrlHostname:4444/grid/console
you should see the Chrome driver registered.

shareimprove this answer
answered Jun 23 '11 at 6:44

sebarmeli
13.5k52638
add a comment
