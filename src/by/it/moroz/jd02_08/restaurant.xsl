<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/clients">
        <table border="1">
            <tr><td>Login</td><td>Email</td><td>Password</td><td>FirstName</td><td>SecondName</td><td>Address</td><td>PhoneNumber</td><td>CreditCard</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/clients/client">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/clients/client/login">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/client_info/firstName">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/client_info/secondName">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/client_info/address">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/client_info/phoneNumber">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/clients/client/client_info/creditCard">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>
