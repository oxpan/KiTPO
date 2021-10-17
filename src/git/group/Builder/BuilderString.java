package git.group.Builder;

import git.group.Comparator.Comparator;
import git.group.Comparator.ComparatorString;

import java.io.InputStreamReader;

public class BuilderString implements Builder
{
    private final int maxLength = 100;
    private final int minCode = 97;
    private final int maxCode = 122;
    private final int diap = maxCode-minCode;


    @Override
    public Object createObject() {
        int sz = (int) (Math.random() * maxLength);
        StringBuffer stringBuffer = new StringBuffer();

        for(int i=0;i<sz;i++)
        {
            int code = (int) (diap * Math.random());
            code = minCode + code;
            stringBuffer.append((char) code);
        }
        return stringBuffer.toString();
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
            return stringBuffer.toString();
        }
        catch(Exception e)
        {
            return  null;
        }
    }

    @Override
    public Object parseObject(String str) {
        return str;
    }

    @Override
    public Comparator getComparator()
    {
        Comparator comparator = new ComparatorString();
        return comparator;
    }
}
