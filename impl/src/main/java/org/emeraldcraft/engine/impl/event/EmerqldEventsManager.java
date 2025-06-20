package org.emeraldcraft.engine.impl.event;

import lombok.Getter;
import org.emeraldcraft.engine.api.GameLogger;
import org.emeraldcraft.engine.api.event.Event;
import org.emeraldcraft.engine.api.event.EventHandler;
import org.emeraldcraft.engine.api.event.EventListener;
import org.emeraldcraft.engine.api.event.EventsManager;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class EmerqldEventsManager implements EventsManager {
    private final HashMap<Class<Event>, List<ResolvedListener>> eventHandlers = new HashMap<>();


    @Override
    public void registerListener(EventListener listener) {
        System.out.println("registering listener");
        Class<? extends EventListener> lisClass = listener.getClass();
        System.out.println("registering listener: " + lisClass.getName());
        Method[] methods = lisClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method name: " + method.getName());
            boolean eventHandler = method.isAnnotationPresent(EventHandler.class);

            System.out.println("event handler: " + eventHandler);

            if(eventHandler){
                Class<?> type = method.getParameters()[0].getType();
                System.out.println("class type: " + type);
                if(!Event.class.isAssignableFrom(method.getParameters()[0].getType())){
                    System.out.println("skipping...");
                    continue;
                }
                System.out.println("its good, continuning!");
                List<ResolvedListener> list = new ArrayList<>();
                list.add(new ResolvedListener(listener, method));
                if(!eventHandlers.containsKey(type) && (eventHandlers.get(type) == null || eventHandlers.get(type).isEmpty())) {
                    System.out.println("creating list...");
                    eventHandlers.put((Class<Event>) type, list);
                }
                else {
                    System.out.println("list already exists...");
                    eventHandlers.get((Class<Event>) type).add(new ResolvedListener(listener, method));
                }
            }

        }

    }

    @Override
    public void unregisterListener(EventListener listener) {
        Class<? extends EventListener> lisClass = listener.getClass();
        Method[] methods = lisClass.getMethods();
        for (Method method : methods) {
            boolean eventHandler = false;
            Annotation[] annotations = method.getAnnotations();

            for (Annotation annotation : annotations) {
                if(annotation instanceof EventHandler){
                    eventHandler = true;
                    break;
                }
            }

            if(eventHandler){
                Class<?> type = method.getParameters()[0].getType();
                if(type != Event.class) continue;


                eventHandlers.get((Class<Event>) type).removeIf(resolvedListener -> resolvedListener.getListener() == listener);
            }

        }
    }

    @Override
    public void dispatchEvent(Event event) {
        if(eventHandlers.containsKey(event.getClass())){
            List<ResolvedListener> list = eventHandlers.get(event.getClass());
            for(ResolvedListener resolvedListener : list){
                try {
                    resolvedListener.getMethod().invoke(resolvedListener.getListener(), event);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    GameLogger.log("Could not dispatch event.");
                    GameLogger.log(e.getMessage());
                }
            }
        }
    }
}

@Getter
class ResolvedListener {
    private final EventListener listener;
    private final Method method;

    ResolvedListener(EventListener listener, Method method) {
        this.listener = listener;
        this.method = method;
    }

}
