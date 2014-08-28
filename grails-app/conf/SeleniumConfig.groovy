selenium {
    slow = false                                    // true to run tests in slow resources mode
    singleWindow = false                            // true for single window mode, false for multi-window mode
//	browser = "*firefox"							// can include full path to executable, default value is *firefox or *iexplore on Windows
    url = "http://localhost:8181/"                    // the base URL for tests, defaults to Grails server url
    defaultTimeout = 10000                        // the timeout after which selenium commands will fail
    windowMaximize = false                        // true to maximize browser on startup
//	remote = true
    screenshot {
        dir = "./target/test-reports/screenshots"    // directory where screenshots are placed relative to project root
        onFail = true                                // true to capture screenshots on test failures
    }
    server {
        host = "localhost"                            // the host the selenium server will run on
        port = 4444                                    // the port the selenium server will run on
    }
    userExtensions = ""                                // path to user extensions javascript file
}
