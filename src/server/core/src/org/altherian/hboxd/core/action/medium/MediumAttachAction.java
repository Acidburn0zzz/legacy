/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2014 Maxime Dor
 * 
 * http://kamax.io/hbox/
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

package org.altherian.hboxd.core.action.medium;

import org.altherian.hbox.comm.Command;
import org.altherian.hbox.comm.HypervisorTasks;
import org.altherian.hbox.comm.Request;
import org.altherian.hbox.comm.in.MachineIn;
import org.altherian.hbox.comm.in.MediumIn;
import org.altherian.hbox.comm.in.ServerIn;
import org.altherian.hbox.comm.in.StorageDeviceAttachmentIn;
import org.altherian.hboxd.core._Hyperbox;
import org.altherian.hboxd.core.action.ASingleTaskAction;
import org.altherian.hboxd.core.model._Medium;
import org.altherian.hboxd.server._Server;
import java.util.Arrays;
import java.util.List;

public class MediumAttachAction extends ASingleTaskAction {

   @Override
   public List<String> getRegistrations() {
      return Arrays.asList(Command.VBOX.getId() + HypervisorTasks.MediumMount.getId());
   }

   @Override
   public boolean isQueueable() {
      return false;
   }

   @Override
   public void run(Request request, _Hyperbox hbox) {
      ServerIn srvIn = request.get(ServerIn.class);
      _Server srv = hbox.getServer(srvIn.getId());

      String mId = request.get(MachineIn.class).getId();
      String ctrlId = request.get(StorageDeviceAttachmentIn.class).getControllerId();
      Long portId = request.get(StorageDeviceAttachmentIn.class).getPortId();
      Long deviceId = request.get(StorageDeviceAttachmentIn.class).getDeviceId();
      String medId = request.get(MediumIn.class).getId();

      _Medium medium = srv.getMedium(medId);
      srv.getMachine(mId).getStorageController(ctrlId).attachMedium(medium, portId, deviceId);
   }

}
