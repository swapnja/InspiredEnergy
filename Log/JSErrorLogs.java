public class JSErrorLogs {
    public static LogEntries getLogs(WebDriver driver) {
        return driver.manage().logs().get(LogType.BROWSER);
    }

    public static Boolean isLoginErrorLog(WebDriver driver) {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        return logEntries.getAll().stream()
            .anyMatch(logEntry -> logEntry.getMessage().contains("An invalid email address was specified"));
    }
}