<#import "paths/common.ftl" as c>
<@c.page>

    <div>
        <form method="post">
            <input type="text" name="name" placeholder="Name" />
            <input type="text" name="user" placeholder="User">
            <button type="submit">Save</button>
        </form>
    </div>
    <br/>
    <#list skillDTO as skillDTOS>
        <div>
        <p>${skillDTOS}
        </div>
    <#else>
        No Person
    </#list>

</@c.page>