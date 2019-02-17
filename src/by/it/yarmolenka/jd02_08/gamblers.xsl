<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/gamblers">
        <table border="1">
            <tr><td>Name</td><td>Password</td><td>Email</td><td>Bets</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/gamblers/gambler">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/gamblers/gambler/login">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/gamblers/gambler/email">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/gamblers/gambler/password">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/gamblers/gambler/bets">
        <td>
            <table border="1">
                <tr><td>Sport</td><td>Event</td><td>Actual bet</td><td>Odds</td>
                    <td>Actual result</td><td>Bet Amount</td><td>Payout</td>
                </tr>
                <xsl:apply-templates/>
            </table>
        </td>
    </xsl:template>

    <xsl:template match="/gamblers/gambler/bets/bet">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/gamblers/gambler/bets/bet/sport">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/gamblers/gambler/bets/bet/event">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/gamblers/gambler/bets/bet/actual_bet">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/gamblers/gambler/bets/bet/odds">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/gamblers/gambler/bets/bet/actual_result">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/gamblers/gambler/bets/bet/bet_amount">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/gamblers/gambler/bets/bet/payout">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>