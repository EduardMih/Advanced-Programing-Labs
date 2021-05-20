import test.Test;

import java.io.File;
import java.lang.reflect.Method;

public class MyTestFramework {
    public static void main(String[] args) throws Exception
    {
        int passed = 0, failed = 0;
        MyClassLoader classLoader = new MyClassLoader();

        //pentru test am mutat MyProgram.class pe Desktop si l-am sters din target/classes ca sa nu mai fie prezent in classpath-ul actual
        classLoader.addURL(new File("C:\\Users\\Eduard\\OneDrive\\Desktop").toURI().toURL());
        for(Method m : classLoader.loadClass("MyProgram").getMethods())
        {
            if(m.isAnnotationPresent(Test.class))
            {
                try
                {
                    m.invoke(null);
                    passed = passed + 1;
                }
                catch(Throwable ex)
                {
                    System.out.println("Test" + m + "failed" + ex.getCause());
                    failed = failed + 1;
                }
            }
        }

        System.out.println("Passed" + passed + " Failed" + failed);

    }
}
