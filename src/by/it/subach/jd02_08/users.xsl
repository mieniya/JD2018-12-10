<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/users">
        <table border="1">
            <tr>
                <tr>
                    <th rowspan="2">Login</th>
                    <th rowspan="2">Email</th>
                    <th rowspan="2">password</th>
                    <th colspan="7">Ads</th>
                </tr>
                <th width="150">Description</th>
                <th>Adress</th>
                <th>Floor</th>
                <th>Floors</th>
                <th>Rooms</th>
                <th>Price</th>
                <th>Area</th>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/users/user">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="/users/user/login">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/email">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/password">
        <td>

            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/ads">
        <td>

            <table border="1" cellpadding="4" cellspacing="0">

                <xsl:apply-templates/>
            </table>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>


    <xsl:template match="/users/user/ads/ad/description">
        <td width="150px">
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad/address">
        <td width="300px">
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad/floor">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad/floors">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad/rooms">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad/price">
        <td width="80px">
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad/area">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>


</xsl:stylesheet>