<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/users">
        <table border="1">
            <tr><td>idUser</td><td>login</td><td>password</td><td>description</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>
    <xsl:template match="/users/user">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/users/user/idUser">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/users/user/login">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/users/user/password">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/users/user/description">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/users/user/description/operations">
        <table border="1">
            <tr><td>idOperation</td><td>nameOperation</td><td>printForm</td><td>skreanForm</td><td>specification</td><td>add</td><td>entrys(idEntry/nameEntry/currencyEntry/accauntDebitEntry/accauntKreditEntry/sumEntry/comingOrSpeting/rateEntry)</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>
    <xsl:template match="/users/user/description/operations/operation">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/users/user/description/operations/operation/idOperation">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/users/user/description/operations/operation/nameOperation">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/users/user/description/operations/operation/printForm">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/users/user/description/operations/operation/skreanForm">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/users/user/description/operations/operation/specification">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/users/user/description/operations/operation/add">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/users/user/description/operations/operation/entrys">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>

