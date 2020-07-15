package session7_abstract_interface.demo;

public abstract class Hinh {


    public static void main(String[] args) {
        Hinh h1 = new Tron();

        Hinh h2 = new TamGiac();

        Hinh h3 = new ChuNhat();

        h2 = h3;
        Hinh h5 = h1;
        //DaGiac h4 = h2;
        Tron h6 = (Tron)h1;
    }
}

class Tron extends Hinh {
}

class ChuNhat extends DaGiac {
}

abstract class DaGiac extends Hinh {
}

class TamGiac extends DaGiac {
}