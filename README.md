# alidade
Java annotations based mapping from html to objects by css selectors

## Example:

```
import com.uberu.alidade.Mapping;
import com.uberu.alidade.Attr;
import com.uberu.alidade.Text;

public class Mapped {
  @Mapping(css="#logout",from=Attr.class, args="href") public String logoutLink;
  @Mapping(css="#logout",from=Text.class) public String logoutText;
}
```

```
import com.uberu.alidade.Alidade;

public class Mapper {
  public static void main(String args[]) {
    Alidade alidade = new Alidade();
    Mapped mapped = new Mapped();
    
    String html = "<html><body><a href="http://www.github.com/gaffo/alidade" id="logout">Logout</a></body></html>";
    alidade.fill(mapped, new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8)));
    
    System.out.println(mapped.logoutLink);
    System.out.println(mapped.logoutText);
  }
}
```

Outputs:

```
http://www.github.com/gaffo/alidade
Logout
```
