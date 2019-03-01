<?xml version="1.0" encoding="UTF-8" standalone="yes" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/jku">
        <table border="1">
            <tr><td>clients</td><td>dispatchers</td><td>brigades</td><td>workPlan</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>


    <xsl:template match="/jku/clients">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/jku/clients/client">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/jku/clients/client/loginClient">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/jku/clients/client/passwordClient">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/jku/clients/client/emailClient">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/jku/clients/client/adressClient">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/jku/clients/client/phoneClient">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/dispatchers">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/jku/dispatchers/dispatcher">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/dispatchers/dispatcher/nameDdspatcher">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/dispatchers/dispatcher/loginDispatcher">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/dispatchers/dispatcher/passwordDispatcher">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/dispatchers/dispatcher/emailDispatcher">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/dispatchers/dispatcher/idNumberDispatcher">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/dispatchers/dispatcher/accessLevel">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/brigades">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/jku/brigades/brigade">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/jku/brigades/brigade/numberBrigade">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/brigades/brigade/brigadier">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/brigades/brigade/workers">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/jku/brigades/brigade/workers/worker">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/brigades/brigade/workers/worker/nameWorker">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/brigades/brigade/workers/worker/post">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/brigades/brigade/workers/worker/phoneWorker">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/workPlan">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/jku/workPlan/months">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/jku/workPlan/months/month">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/workPlan/months/month/nameMonth">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/workPlan/months/month/requests">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/jku/workPlan/months/month/requests/request">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/workPlan/months/month/requests/request/idRequest">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/workPlan/months/month/requests/request/dataCreate">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/workPlan/months/month/requests/request/dataComplite">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/workPlan/months/month/requests/request/clientRequest">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/workPlan/months/month/requests/request/dispatcherRequest">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/workPlan/months/month/requests/request/brigadeRequest">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/jku/workPlan/months/month/requests/request/status">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>