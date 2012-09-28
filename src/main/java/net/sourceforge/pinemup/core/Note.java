/*
 * pin 'em up
 *
 * Copyright (C) 2007-2012 by Mario Ködding
 *
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package net.sourceforge.pinemup.core;

import java.util.Observable;

public class Note extends Observable {
   public static final short MIN_FONT_SIZE = 5;
   public static final short MAX_FONT_SIZE = 30;

   private String text;

   private boolean hidden;
   private boolean alwaysOnTop;

   private short xpos, ypos, xsize, ysize, fontSize;

   private NoteColor color;

   private Category category;

   public void setAlwaysOnTop(boolean alwaysOnTop) {
      if (alwaysOnTop != this.alwaysOnTop) {
         this.alwaysOnTop = alwaysOnTop;
         setChanged();
         notifyObservers();
      }
   }

   public boolean isAlwaysOnTop() {
      return alwaysOnTop;
   }

   public void setFontSize(short fontSize) {
      if (fontSize != this.fontSize && fontSize >= MIN_FONT_SIZE && fontSize <= MAX_FONT_SIZE) {
         this.fontSize = fontSize;
         notifyObservers();
      }
   }

   public short getFontSize() {
      return fontSize;
   }

   public void setHidden(boolean hidden) {
      if (hidden != this.hidden) {
         this.hidden = hidden;
         setChanged();
         notifyObservers();
      }
   }

   public boolean isHidden() {
      return hidden;
   }

   public Note() {
      text = "";
      hidden = false;
      xpos = UserSettings.getInstance().getDefaultWindowXPostition();
      ypos = UserSettings.getInstance().getDefaultWindowYPostition();
      xsize = UserSettings.getInstance().getDefaultWindowWidth();
      ysize = UserSettings.getInstance().getDefaultWindowHeight();
      fontSize = UserSettings.getInstance().getDefaultFontSize();
      alwaysOnTop = UserSettings.getInstance().getDefaultAlwaysOnTop();
      color = NoteColor.DEFAULT_COLOR;
   }

   public void setText(String text) {
      if (!text.equals(this.text)) {
         this.text = text;
         setChanged();
         notifyObservers();
      }
   }

   public String getText() {
      return text;
   }

   public void setPosition(short x, short y) {
      if (x != xpos || y != ypos) {
         xpos = x;
         ypos = y;
         setChanged();
         notifyObservers();
      }
   }

   public short getXPos() {
      return xpos;
   }

   public short getYPos() {
      return ypos;
   }

   public void setSize(short x, short y) {
      if (x != xsize || y != ysize) {
         xsize = x;
         ysize = y;
         setChanged();
         notifyObservers();
      }
   }

   public short getXSize() {
      return xsize;
   }

   public short getYSize() {
      return ysize;
   }

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      if (category != this.category) {
         this.category = category;
         setChanged();
         notifyObservers();
      }
   }

   public void setColor(NoteColor color) {
      this.color = color;
      setChanged();
      notifyObservers();
   }

   public NoteColor getColor() {
      return color;
   }

   public void refreshCategoryInfo() {
      setChanged();
      notifyObservers();
   }

   public void markForObservers() {
      setChanged();
   }
}
