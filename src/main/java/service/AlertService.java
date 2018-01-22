package service;

public interface AlertService {

    void sendAlert(String message);

    void receiveAlert(String message);
}
