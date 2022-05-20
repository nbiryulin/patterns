package lab1.observer.models;



import lab1.observer.FigureEnum;
import lab1.observer.Subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Publisher {

    private final Map<FigureEnum, List<Subscriber>> listeners;

    public Publisher() {
        listeners = new HashMap<>();
    }

    public void subscribe(FigureEnum typeEvent, Subscriber subscriber) {
        listeners.computeIfAbsent(typeEvent, k -> new ArrayList<>()).add(subscriber);
    }

    public void unsubscribe(FigureEnum typeEvent, Subscriber subscriber) throws Exception {
        List<Subscriber> subscribers = listeners.get(typeEvent);

        if (subscribers == null) {
            throw new Exception("Type doesn't exist");
        }

        subscribers.remove(subscriber);
    }

    public void notify(FigureEnum typeEvent) throws Exception {
        List<Subscriber> subscribers = listeners.get(typeEvent);

        if (subscribers == null) {
            throw new Exception("Type doesn't exist");
        }

        subscribers.forEach(Subscriber::update);
    }
}
