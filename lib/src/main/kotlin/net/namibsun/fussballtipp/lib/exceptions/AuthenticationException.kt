/*
Copyright 2018 Hermann Krumrey <hermann@krumreyh.com>

This file is part of fussballtipp-android.

fussballtipp-android is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

fussballtipp-android is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with fussballtipp-android.  If not, see <http://www.gnu.org/licenses/>.
*/

package net.namibsun.fussballtipp.lib.exceptions

/**
 * Exception thrown whenever a login failed due to incorrect credentials
 */
class AuthenticationException(username: String) : Exception(username)
