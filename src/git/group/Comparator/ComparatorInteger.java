package git.group.Comparator;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ComparatorInteger implements Comparator, Serializable
{
    @Override
    public int compare(Object o1, Object o2)
    {
        if(o1 instanceof Integer && o2 instanceof Integer)
        {
            try
            {
                Class cl = o1.getClass();
                Method m = cl.getMethod("compareTo",Integer.class);
                return (int) m.invoke(o1,o2);
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return -2;
            }
        }
        return -2;
    }
}
