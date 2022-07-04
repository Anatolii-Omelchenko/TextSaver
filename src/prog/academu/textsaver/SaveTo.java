package prog.academu.textsaver;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SaveTo {
    String path() default "D:\\file.txt";
}
