/*
 * Copyright (c) 2018 William Barkoff.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package TheWaterOfNewYorkCity;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args) throws NotInListException, IOException {
        Reader data = new FileReader("resources/TheWaterOfNewYorkCity/nycfreepublicwifi.csv");

        DoublyLinkedList<AccessPoint> waps = new DoublyLinkedList<>();

        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(data);
        for (CSVRecord record : records) {
            String SSID = record.get("SSID");
            String boroName = record.get("BORO");
            String remarks = record.get("REMARKS");
            int id = Integer.parseInt(record.get("OBJECTID"));
            String provider = record.get("PROVIDER");
            String name = record.get("NAME");
            double latitude = Double.parseDouble(record.get("LAT"));
            double longitude = Double.parseDouble(record.get("LON"));
            String address = record.get("LOCATION");
            int zipCode = Integer.parseInt(record.get("POSTCODE"));

            AccessPoint.Boro boro = null;
            switch(boroName) {
                case "BX": boro = AccessPoint.Boro.BRONX;
                case "BK": boro = AccessPoint.Boro.BROOKLYN;
                case "QU": boro = AccessPoint.Boro.QUEENS;
                case "SI": boro = AccessPoint.Boro.STATEN_ISLAND;
                case "MN": boro = AccessPoint.Boro.MANHATTAN;
            }
            AccessPoint wap = new AccessPoint(SSID, boro, remarks, id, provider, name, latitude, longitude, address, zipCode);
            waps.add(wap);
        }

        double daltonLat = 40.781541;
        double daltonLon = -73.955056;

        AccessPoint closest = null;
        double closestDistance = Double.MAX_VALUE; // Maximum value, because it will make the comparisons always work
        for (int i = 0; i < waps.getLength(); i++) {
            AccessPoint wap = waps.get(i);
            double distance = wap.calculateDistance(daltonLat, daltonLon);
            if(distance < closestDistance) {
                closestDistance = distance;
                closest = wap;
            }
        }
        System.out.println("Closest WiFi hotspot to Dalton:");
        System.out.println(closest.toString());

    }
}
