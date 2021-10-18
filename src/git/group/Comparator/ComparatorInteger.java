package git.group.Comparator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ComparatorInteger implements Comparator
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
//                Field f = cl.getDeclaredField("value");
//                int a,b;
//                a = (int) f.get(o1);
//                b = (int) f.get(o2);
//
//                if (a == b) return 0;
//                else if (a>b) return 1;
//                else if (a<b) return -1;

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
