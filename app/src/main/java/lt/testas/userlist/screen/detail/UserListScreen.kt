package lt.testas.userlist.screen.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import lt.testas.userlist.R
import lt.testas.userlist.SampleData
import lt.testas.userlist.component.AppTextField
import lt.testas.userlist.component.Gap
import lt.testas.userlist.network.dto.UserDto
import lt.testas.userlist.network.dto.UserNameDto
import lt.testas.userlist.theme.theme.TestUserListTheme
import lt.testas.userlist.theme.theme.TestUserTheme

@Composable
fun UserListScreen(
    state: UserListViewModel.State,
    filterUsers: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(horizontal = TestUserTheme.dimen.screenHorizontalPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val filterValue = remember { mutableStateOf("") }
        Gap(TestUserTheme.dimen.screenVerticalPadding)
        Text(
            text = stringResource(id = R.string.user_list_title),
            style = MaterialTheme.typography.h6
        )
        Gap()
        AppTextField(
            value = filterValue.value,
            onValueChange = {
                filterValue.value = it
                filterUsers.invoke(it)
            }
        )
        Gap()
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentPadding = PaddingValues(bottom = TestUserTheme.dimen.screenVerticalPadding)
        ) {
            val users = if (filterValue.value.isEmpty()) state.originalUsers else state.filteredUsers
            users.forEach { user ->
                item { UserItem(user) }
            }
        }
    }
}

@Composable
private fun UserItem(user: UserDto) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(user.picture.thumbnail)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_user_image_pl),
            contentDescription = stringResource(R.string.user_image_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp)
        )
        Spacer(modifier = Modifier.width(TestUserTheme.dimen.elementGap))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = user.name.getFullName(),
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = user.email,
                style = MaterialTheme.typography.body2,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Gap(4.dp)
            Text(
                text = "${user.address.street.name} ${user.address.street.name}",
                style = MaterialTheme.typography.caption,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = user.address.city,
                style = MaterialTheme.typography.caption,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Row {
                Text(
                    text = user.address.country,
                    style = MaterialTheme.typography.caption,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Gap(4.dp)
                Text(
                    text = user.address.postCode.toString(),
                    style = MaterialTheme.typography.caption,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Gap(4.dp)
            Divider()
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    TestUserListTheme {
        UserListScreen(
            UserListViewModel.State(
                originalUsers = listOf(
                    SampleData.userDto.copy(
                        name = UserNameDto(
                            title = "Mr",
                            name = "This is a very long name",
                            surname = "Long surname"
                        )
                    ),
                    SampleData.userDto,
                    SampleData.userDto
                )
            ),
            {}
        )
    }
}