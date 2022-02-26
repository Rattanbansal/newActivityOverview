<?xml version="1.0" encoding="UTF-8"?>
<WebElementEntity>
   <description>Click On Details Under product Type Section

here in the position 1 it contains that which product detail section we need to click but it will remain same because we have extra class added there as active

and on position2 we have maximum 4 value as following:

1: details
2: Linked
3: Pricing
5: Pass

4 value is for voucher which hidden currently</description>
   <name>Details</name>
   <tag></tag>
   <elementGuidId>d2b77fe0-bc83-400f-8d7c-39b1a006fc8b</elementGuidId>
   <selectorCollection>
      <entry>
         <key>XPATH</key>
         <value>(//div[@class='order-detail-left']//li[@class='order-list confirm hash-link-parent active'])[${position}]//ul[@class='tabs custom-tabs']//li[${position2}]//a</value>
      </entry>
      <entry>
         <key>BASIC</key>
         <value></value>
      </entry>
   </selectorCollection>
   <selectorMethod>XPATH</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
</WebElementEntity>
