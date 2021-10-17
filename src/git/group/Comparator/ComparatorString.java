package git.group.Comparator;

import java.lang.reflect.*;


public class ComparatorString implements Comparator
{
    @Override
    public int compare(Object o1, Object o2)
    {
        if (o1 instanceof String && o2 instanceof String)
        {
            try
            {
                Method m = o1.getClass().getMethod("length");
                int l1 = (int) m.invoke(o1);
                int l2 = (int) m.invoke(o2);
                if (l1 == l2) return 0;
                else if (l1>l2) return 1;
                else if (l1<l2) return -1;
            }
            catch(Exception e)
            {
               return -2;
            }
        }
        return -2;
    }
}
