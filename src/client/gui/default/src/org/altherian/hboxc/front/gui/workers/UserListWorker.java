/*
 * Hyperbox - Enterprise Virtualization Manager
 * Copyright (C) 2015 Maxime Dor
 * 
 * http://hyperbox.altherian.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.altherian.hboxc.front.gui.workers;

import org.altherian.hbox.comm.out.security.UserOut;
import org.altherian.hboxc.front.gui.Gui;
import org.altherian.hboxc.front.gui.utils.AxSwingWorker;
import org.altherian.hboxc.front.gui.worker.receiver._UserListReceiver;
import java.util.List;

public class UserListWorker extends AxSwingWorker<_UserListReceiver, Void, UserOut> {

   private String srvId;

   public UserListWorker(_UserListReceiver recv, String srvId) {
      super(recv);
      this.srvId = srvId;
   }

   @Override
   protected Void doInBackground() throws Exception {
      for (UserOut usrOut : Gui.getServer(srvId).listUsers()) {
         publish(usrOut);
      }

      return null;
   }

   @Override
   protected void process(List<UserOut> usrOutList) {
      getReceiver().add(usrOutList);
   }

   public static void execute(_UserListReceiver recv, String srvId) {
      (new UserListWorker(recv, srvId)).execute();
   }

}
