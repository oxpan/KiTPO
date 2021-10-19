package git.group.Builder;

import git.group.Comparator.Comparator;

import java.io.InputStreamReader;

public interface Builder
{
    Object createObject();
    Object readObject(InputStreamReader in);
    Object parseObject(String str);
    Comparator getComparator();
    String getName();
}
