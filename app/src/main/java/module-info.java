module cs2263.main {
    requires javafx.controls;
    requires javafx.graphics;
    requires com.google.gson;
    exports edu.isu.cs.cs2263;
    exports edu.isu.cs.cs2263.javafx;
    exports edu.isu.cs.cs2263.gson;
    exports edu.isu.cs.cs2263.serialization;
    opens edu.isu.cs.cs2263.gson to com.google.gson;
    opens edu.isu.cs.cs2263 to com.google.gson;
}