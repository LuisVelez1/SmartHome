package org.HomeFunctional.Singleton;

public class SmartHomeConfig {
    private static SmartHomeConfig instance;
    private String homeName;
    private boolean securityModeActive;

    private SmartHomeConfig() {
        this.homeName = "Main smart home";
        this.securityModeActive = false;
    }

    public static synchronized SmartHomeConfig getInstance() {
        if (instance == null) {
            instance = new SmartHomeConfig();
        }
        return instance;
    }

    public String getHomeName() {
        return homeName; }
    public void setHomeName(String homeName) {
        this.homeName = homeName; }
    public boolean isSecurityModeActive() {
        return securityModeActive; }
    public void setSecurityModeActive(boolean securityModeActive) {
        this.securityModeActive = securityModeActive; }
}