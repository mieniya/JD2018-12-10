<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/users">
        <table border="1">
            <tr><th>login</th><th>email</th><th>password</th><th>advertisment</th></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/users/user">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/users/user/login">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/ads">
        <td>
            <table>
                <xsl:apply-templates/>
            </table>
        </td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad/description">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad/address">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad/floor">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad/floors">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad/rooms">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad/price">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/ads/ad/area">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>
