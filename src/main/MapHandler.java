package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

class MapHandler {
    ArrayList <String> WallBuffer;
	ArrayList<Wall> walls;
	ArrayList<BetaOrb> orb;

    public MapHandler() {
	   walls = new ArrayList<Wall>();
	   orb = new ArrayList<BetaOrb>();
    }
    public ArrayList<ArrayList> init(int lvl) {
		ArrayList<String> WallBuffer = new ArrayList<String>();
		File level = new File("level"+lvl);
        LineIterator it;
        
		ArrayList<Wall> w = null;
		ArrayList<ArrayList> items = null;
		
		try {
			it = FileUtils.lineIterator(level, "UTF-8");
			try {
				while (it.hasNext()) {
					WallBuffer.add(it.nextLine());
				}
			} finally {
				it.close();
                //paintLevel(WallBuffer);
                items = paintLevel(WallBuffer);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
        return items;
    }
    
    public ArrayList<ArrayList> paintLevel(ArrayList<String> lvl) {
		/* for (int vertical = 0; vertical<lvl.size(); vertical++) {
			System.out.println(lvl.get(vertical));
		} */
		
		for (int index = 0; index<lvl.size(); index++) {
			for (int indexOfChar = 0; indexOfChar < lvl.get(index).length(); indexOfChar++) {
				int s = lvl.get(index).codePointAt(indexOfChar);

				switch (s) {
					case 49:
						walls.add(new Wall(indexOfChar, index));
						break;
					case 48:
						//do nothing, because you can't add the void.
						break;
					case 57:
						//TODO add the BetaOrb.
						orb.add(new BetaOrb(indexOfChar, index));
						break;
					default:
						//Unknown Data
						System.out.println(s);
						break;
				}
			}
		}

		//Package everyting
		ArrayList<ArrayList> listOfEverything = new ArrayList<ArrayList>();
		listOfEverything.add(walls);
		listOfEverything.add(orb);
		return listOfEverything;
	}
}

//57 == "Beta Orb"
//49 == "Wall"
//48 == "void"