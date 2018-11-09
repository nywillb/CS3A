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

import java.util.Objects;


/**
 *
 */
public class AccessPoint {
    private String SSID;
    private Boro boro;
    private String remarks;
    private int id;
    private String provider;
    private String name;
    private double latitude;
    private double longitude;
    private String address;
    private int zipCode;

    public AccessPoint(String SSID, Boro boro, String remarks, int id, String provider, String name, double latitude, double longitude, String address, int zipCode) {
        this.SSID = SSID;
        this.boro = boro;
        this.remarks = remarks;
        this.id = id;
        this.provider = provider;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.zipCode = zipCode;
    }

    public AccessPoint(String csvInput) {
        String[] details = csvInput.split(",");
        this.id = Integer.parseInt(details[1]);
        switch(details[2]) {
            case "BX": this.boro = Boro.BRONX;
            case "BK": this.boro = Boro.BROOKLYN;
            case "QU": this.boro = Boro.QUEENS;
            case "SI": this.boro = Boro.STATEN_ISLAND;
            case "MN": this.boro = Boro.MANHATTAN;
        }
        this.provider = details[4];
        this.name = details[5];
        this.address = details[6];
        this.latitude = Double.parseDouble(details[7]);
        this.longitude = Double.parseDouble(details[8]);
        this.remarks = details[12];
        this.zipCode = Integer.parseInt(details[22]);
        this.SSID = details[14];
    }

    public String getSSID() {
        return SSID;
    }

    public Boro getBoro() {
        return boro;
    }

    public String getRemarks() {
        return remarks;
    }

    public int getId() {
        return id;
    }

    public String getProvider() {
        return provider;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public double calculateDistance(AccessPoint point) {
       return calculateDistance(point.getLatitude(), point.getLongitude());
    }

    public double calculateDistance(double latitude, double longitude) {
        return Math.sqrt(Math.abs(Math.pow(this.latitude - latitude, 2)+Math.pow(this.longitude - longitude, 2)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessPoint that = (AccessPoint) o;
        return getId() == that.getId() &&
                Double.compare(that.getLatitude(), getLatitude()) == 0 &&
                Double.compare(that.getLongitude(), getLongitude()) == 0 &&
                getZipCode() == that.getZipCode() &&
                Objects.equals(getSSID(), that.getSSID()) &&
                getBoro() == that.getBoro() &&
                Objects.equals(getRemarks(), that.getRemarks()) &&
                Objects.equals(getProvider(), that.getProvider()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccessPoint{");
        sb.append("SSID='").append(SSID).append('\'');
        sb.append(", boro=").append(boro);
        sb.append(", remarks='").append(remarks).append('\'');
        sb.append(", provider='").append(provider).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", address='").append(address).append('\'');
        sb.append(", zipCode=").append(zipCode);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSSID(), getBoro(), getRemarks(), getId(), getProvider(), getName(), getLatitude(), getLongitude(), getAddress(), getZipCode());
    }

    public enum Boro {
        MANHATTAN,
        BRONX,
        QUEENS,
        STATEN_ISLAND,
        BROOKLYN
    }
}
