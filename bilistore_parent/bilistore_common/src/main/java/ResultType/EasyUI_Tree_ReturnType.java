package ResultType;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 下午4:38 2018/9/16
 * @ Description：商品条目返回数据类型
 * @ Modified By：
 * @Version: $
 * 商品条目接收一个JsonArray,List<EasyUI_Tree_ReturnType>
 *  每个JsonObject是
 *  id 1 2 3。。。。
 *  text
 *  state 父节点为closed 子节点为open
 */
public class EasyUI_Tree_ReturnType {
    private long id;
    private String text;
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
