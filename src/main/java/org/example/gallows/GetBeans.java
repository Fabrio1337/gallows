package org.example.gallows;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GetBeans {
    private static AnnotationConfigApplicationContext context;

    public static AnnotationConfigApplicationContext getContext() {
        if (context == null) {
            context = new AnnotationConfigApplicationContext(AllAnnotations.class);
        }
        return context;
    }
}
