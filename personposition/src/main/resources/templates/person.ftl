<#import "paths/common.ftl" as c>
<@c.page>

    <div>
        <form method="post">
            <Div>
                <input type="text" name="name" placeholder="Name" />
            </Div>
            <Div>
                <input type="text" name="surname" placeholder="Surname">
            </Div>
            <Div>
                <input type="text" name="gender" placeholder="Gender">
            </Div>
            <Div>
                <input type="text" name="age" placeholder="Age">
            </Div>
            <Div>
                <input type="text" name="status" placeholder="Status">
            </Div>
            <Div>
                <input type="text" name="skills" placeholder="Skills">
            </Div>

            <button type="submit">Save</button>
        </form>
    </div>
    <br/>
    <#list personDTO as personDTOS>
        <div>
            <p>${personDTOS}
        </div>
    <#else>
        No Person
    </#list>

</@c.page>