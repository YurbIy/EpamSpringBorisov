package quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor{

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if(annotation != null){
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int i = min + random.nextInt(max - min);
                field.setAccessible(true);
                ReflectionUtils.setField(field,  bean, i);
            }
        }
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
