/* 
    ---- Make sure to do regual commits and push to repo! ---- 

    Forking Repo 
        git clone http://github.com/JimKirkStudent/OOP-2018-2019
        cd OOP-2018-2019
        git remote -v
            should be like this:
            origin        http://github.com/JimKirkStudent/OOP-2018-2019 (fetch)
            origin        http://github.com/JimKirkStudent/OOP-2018-2019 (push)
            upstream  http://github.com/skooter500/OOP-2018-2019 (fetch)
            upstream  http://github.com/skooter500/OOP-2018-2019 (push)
        
        git remote add upstream http://github.com/skooter500/OOP-2018-2019

        git pull upstream master
        git push origin branchName


    Getting a column from a row:
        public Star(TableRow row)
        {
            this.hab = row.getInt("Hab?");
            this.displayName = row.getString("DisplayName");
            this.distance = row.getFloat("Distance");
            this.xG = row.getFloat("Xg");
            this.yG = row.getFloat("Xy");
            this.zG = row.getFloat("Xz");
            this.absMag = row.getFloat("absMag");
        }
    
    Creating and Initializing an Array List (holds Star objects):
        private ArrayList<Star> stars = new ArrayList<Star>(); 

    Creating and Loading in data from file into a table
        Table table = loadTable("HabHYG15ly.csv", "header");

    Getting a row from a table:
        table.getRow(i)r

    or do it using a foreach loop
        for (TableRow row : table.rows()) {
            Star star = new Star(row);
            stars.add(star);
        }

    Drawing Grid:
        for (int i = -5; i < 6; i++) {
            float var = map(i, -5, 5, border, screenDim - border);

            // vertical lines
            line(var, border, var, screenDim - border);
            text(i, var, border/2);

            // horizontal lines
            line(border, var, screenDim - border, var);
            text(i, border/2, var);
        }

    Buttons:
        if ((mouseX > border && mouseX < border + buttonWidth))
        {
            if ((mouseY - border) % (buttonHeight + gap) < buttonHeight)
            {
                which = (int) ((mouseY - border) / (buttonHeight + gap));
            }
        }
*/