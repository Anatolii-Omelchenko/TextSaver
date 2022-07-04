package prog.academu.textsaver;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {

        Class<?> textCls = TextContainer.class;
        Class<?> saverCls = Saver.class;

        Field textField = textCls.getDeclaredField("TEXT");
        textField.setAccessible(true);
        String text = textField.get(null).toString();

        SaveTo annotation = textCls.getAnnotation(SaveTo.class);
        String path = annotation.path();

        Method[] methods = saverCls.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Save.class)) {
                method.invoke(null, text, path);
            }
        }

    }
}
