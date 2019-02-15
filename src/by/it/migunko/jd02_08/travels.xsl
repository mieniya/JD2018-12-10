<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/travels">
        <table border="1">
            <tr><td>login</td><td>password</td><td>email</td><td align="center">travels</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/travels/travel">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/travels/travel/login">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/travels/travel/password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/travels/travel/email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/travels/travel/travelTours">
        <td>
            <table width="100%" cellpadding="2" cellspacing="1" border="1">
                <tr><td>typeOfTravel</td><td>destination</td><td>hotel</td><td>countOfNight</td>
                    <td>price</td>
                </tr>
                <xsl:apply-templates/>
            </table>
        </td>
    </xsl:template>

    <xsl:template match="/travels/travel/travelTours/travelTour">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/travels/travel/travelTours/travelTour/typeOfTravel">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/travels/travel/travelTours/travelTour/destination">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/travels/travel/travelTours/travelTour/hotel">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/travels/travel/travelTours/travelTour/countOfNight">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/travels/travel/travelTours/travelTour/price">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>