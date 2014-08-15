@ECHO
call gradlew.bat setupDecompWorkspace --refresh-dependencies
call gradlew.bat eclipse --refresh-dependencies
PAUSE