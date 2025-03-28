public class Color {//静态方法 用于处理一些随值变化场景 暂用名color
    public static String Cell(int x) {//处理了每个cell的背景颜色
        if (x <= 1) {
            return "#CDC1B4";
        } else if (x <= 2) {
            return "pink";
        } else if (x <= 4) {
            return "lightblue";
        } else if (x <= 8) {
            return "lightgreen";
        } else if (x <= 16) {
            return "lightcoral";
        } else if (x <= 32) {
            return "lightsalmon";
        } else if (x <= 64) {
            return "lightseagreen";
        } else if (x <= 128) {
            return "lightgoldenrodyellow";
        } else if (x <= 256) {
            return "lightsteelblue";
        } else if (x <= 512) {
            return "lightpink";
        } else if (x <= 1024) {
            return "lightcyan";
        } else if (x <= 2048) {
            return "lightyellow";
        }
        return "white";
    }
}
