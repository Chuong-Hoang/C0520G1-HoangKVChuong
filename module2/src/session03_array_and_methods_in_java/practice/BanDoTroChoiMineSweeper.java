package session03_array_and_methods_in_java.thuc_hanh;

public class BanDoTroChoiMineSweeper {
    public static void main(String[] args) {
        String[][] map = {
                {"*", ".", "*", ".", "."},
                {"*", ".", "*", ".", "*"},
                {"*", ".", ".", "*", "."},
                {".", "*", "*", ".", "*"}
        };
        final int MAP_HEIGHT = map.length;
        final int MAP_WIDTH = map[0].length;

        String[][] mapReport = new String[MAP_HEIGHT][MAP_WIDTH];
        for(int yOrdinate = 0; yOrdinate < MAP_HEIGHT; yOrdinate++) {
            for (int xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
                String currentCell = map[yOrdinate][xOrdinate];
                if (currentCell.equals("*")) {
                    mapReport[yOrdinate][xOrdinate] = " * ";
                } else {
                    final int[][] NEIGHBORS_ORDINATE = {
                            {yOrdinate, xOrdinate - 1}, {yOrdinate, xOrdinate + 1}
                    };

                    int minesAround = 0;
                    for (int i = 0; i < NEIGHBORS_ORDINATE.length; i++) {
                        int[] neighborOrdinate = NEIGHBORS_ORDINATE[i];
                        int xOrdinateOfNeighbor = neighborOrdinate[1];
                        int yOrdinateOfNeighbor = neighborOrdinate[0];

                        boolean isOutOfMapNeighbor = xOrdinateOfNeighbor < 0 || xOrdinateOfNeighbor == MAP_WIDTH ||
                                yOrdinateOfNeighbor < 0 || yOrdinateOfNeighbor == MAP_HEIGHT;
                        if (isOutOfMapNeighbor) continue;

                        boolean isMineOwnerNeighbor = map[yOrdinateOfNeighbor][xOrdinateOfNeighbor].equals("*");
                        if (isMineOwnerNeighbor) minesAround++;
                    }

//                boolean hasNeighborAtLeft = xOrdinate - 1 >= 0;
//                boolean hasMineAtLeft = hasNeighborAtLeft && map[0][xOrdinate-1].equals("*");
//                if(hasMineAtLeft) minesAround++;
//
//                boolean hasNeighborAtRight = xOrdinate + 1 < MAP_WIDTH;
//                boolean hasMineAtRight = hasNeighborAtRight && map[0][xOrdinate+1].equals("*");
//                if(hasMineAtRight) minesAround++;

                    mapReport[yOrdinate][xOrdinate] = String.valueOf(minesAround);
                }
            }
        }

        for(int yOrdinate = 0; yOrdinate < MAP_HEIGHT; yOrdinate++) {
            for (int xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
                String currentCellReport = mapReport[yOrdinate][xOrdinate];
                System.out.print(currentCellReport + " ");
            }
            System.out.println("");
        }

    }
}
