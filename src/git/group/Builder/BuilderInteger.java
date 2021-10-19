package git.group.Builder;

import git.group.Comparator.Comparator;
import git.group.Comparator.ComparatorInteger;

import java.io.InputStreamReader;
import java.io.Serializable;

public class BuilderInteger implements Builder, Serializable
{
    public static final String typename = new String("Integer");

    private final int min = 0;
    private final int max = 100;

    @Override
    public Object createObject() {
        int val = (int) (Math.random() * (max - min));
        val = min + val;
        return new Integer(val);
    }

    @Override
    public Object readObject(InputStreamReader in) {
        try
        {
            StringBuffer stringBuffer = new StringBuffer();
            int code =0;
            while ((code = in.read())!= -1)
            {
                stringBuffer.append((char) code);
            }
            return new Integer(Integer.parseInt(stringBuffer.toString()));
        }
        catch(Exception e)
        {
            return  null;
        }
    }

    @Override
    public Object parseObject(String str)
    {
        return new Integer(Integer.parseInt(str));
    }

    @Override
    public Comparator getComparator() {
        Comparator comparator = new ComparatorInteger();
        return comparator;
    }

    @Override
    public String getName() {
        return typename;
    }
}
