**Modules**: 5
1. app
2. common
3. core
4. data
5. feat_show_details
6. feat_shows

**Pattern**: Model-View-Intent (MVI)

**COMMON** modules contains reusable Jetpack components (UI)
**CORE** module contains utilities, dispatcher, handler, model and navigation
**DATA** module contains api calls data and repo interfaces
**FEAT_SHOWS** module contains UI for home screen for fetching list of shows. contains concrete implementations,
               viewmodels, DI
**FEAT_SHOWS_DETAILS** module contains UI for show details for displaying show details. contains concrete implementations
               viewmodels, DI