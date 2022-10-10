let header = document.createElement('header');

header.className = 's-topbar ps-fixed t0 l0 js-top-bar';
header.innerHTML = `
    <div class="s-topbar--container">
    
    
    <a href="https://ru.stackoverflow.com" class="s-topbar--logo js-gps-track"
        data-gps-track="top_nav.click({is_current:true, location:1, destination:8})">
        <span class="-img _glyph">Stack Overflow &#x43D;&#x430;
            &#x440;&#x443;&#x441;&#x441;&#x43A;&#x43E;&#x43C;</span>
    </a>

    <form id="search" role="search" action=/search class="s-topbar--searchbar js-searchbar " autocomplete="off">
        <div class="s-topbar--searchbar--input-group">

            <input name="q" type="text" placeholder="&#x41F;&#x43E;&#x438;&#x441;&#x43A;..." value=""
                autocomplete="off" maxlength="240" class="s-input s-input__search js-search-field "
                aria-label="&#x41F;&#x43E;&#x438;&#x441;&#x43A;" aria-controls="top-search"
                data-controller="s-popover" data-action="focus->s-popover#show"
                data-s-popover-placement="bottom-start" />
                
            <svg aria-hidden="true" class="s-input-icon s-input-icon__search svg-icon iconSearch" width="18"
                height="18" viewBox="0 0 18 18">
                <path
                    d="m18 16.5-5.14-5.18h-.35a7 7 0 1 0-1.19 1.19v.35L16.5 18l1.5-1.5ZM12 7A5 5 0 1 1 2 7a5 5 0 0 1 10 0Z" />
            </svg>
            
        </div>
    </form>


    <nav class="h100 ml-auto overflow-x-auto pr12">
        <ol class="s-topbar--content" role="menubar">

            <li role="none">
                <a href="#"
                    class="s-topbar--item s-topbar--item__unset s-btn s-btn__filled ws-nowrap js-gps-track">
                    Мой Профиль
                </a>
            </li>
            
        </ol>
    </nav>


    </div>
`;

document.body.prepend(header);